package cn.ywh.partybuilding.net;

import android.content.Context;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.ywh.partybuilding.utils.ECache;
import cn.ywh.partybuilding.utils.YyInterceptor;
import cn.ywh.partybuilding.utils.YySavePreference;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static cn.ywh.partybuilding.net.NetConstant.ConnectionTime;


/**
 * Created by Ywh on 2018/4/12.
 * Email：787875249@qq.com
 * Function： 网络访问服务类
 * Company：四川复兴科技有限公司
 */

public class NetService {

    public static final String TOKEN = "api_token";
    public static final String HEADER_TOKEN = "TOKEN";
    private static ServiceApi dataRequest;
    private static Interceptor interceptor;
    private static OkHttpClient client;
    ;

    /**
     * API 服务获取
     *
     * @param context
     * @return
     */
    public static ServiceApi getApiService(final Context context) {
        if (dataRequest == null) {
            initInterceptor(context);
            initHttp();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(NetConstant.HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client)
                    .build();
            dataRequest = retrofit.create(ServiceApi.class);
        }
        return dataRequest;
    }


    private static void initInterceptor(final Context context) {
        interceptor = new Interceptor(
        ) {
            @Override
            public Response intercept(Chain chain) throws IOException {
                ECache cache = ECache.get(context, HEADER_TOKEN);

                String token =/* cache.getAsString(TOKEN);*/
                        YySavePreference.getString(TOKEN);
                if (token == null)
                    token = "";
                Request newRequest = chain.request().newBuilder().addHeader(HEADER_TOKEN, token).build();
                return chain.proceed(newRequest);

            }

        };
    }

    private static void initHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (interceptor != null)
            builder.addInterceptor(interceptor);
        client = builder.connectTimeout(ConnectionTime, TimeUnit.MILLISECONDS)
                .readTimeout(ConnectionTime, TimeUnit.MILLISECONDS)
                .writeTimeout(ConnectionTime, TimeUnit.MILLISECONDS)
                .addInterceptor(new YyInterceptor())
                .build();
    }
}
