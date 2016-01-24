package changjiashuai.github.io.rxjavatest.v5;

import android.net.Uri;

import java.util.List;

import changjiashuai.github.io.rxjavatest.v1.Cat;
import changjiashuai.github.io.rxjavatest.v3.Api;
import changjiashuai.github.io.rxjavatest.v4.Callback;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/23 23:50.
 */
public class ApiWrapper {
    Api api;

    public AsyncJob<List<Cat>> queryCats(final String query){
        return new AsyncJob<List<Cat>>() {
            @Override
            public void start(final Callback<List<Cat>> callback) {
                api.queryCats(query, new Api.CatsQueryCallback() {
                    @Override
                    public void onCatListReceived(List<Cat> cats) {
                        callback.onResult(cats);
                    }

                    @Override
                    public void onQueryFailed(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
    }

    public AsyncJob<Uri> store(final Cat cat){
        return new AsyncJob<Uri>() {
            @Override
            public void start(final Callback<Uri> callback) {
                api.store(cat, new Api.StoreCallback() {
                    @Override
                    public void onCatStored(Uri uri) {
                        callback.onResult(uri);
                    }

                    @Override
                    public void onStoreFailed(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
    }
}
