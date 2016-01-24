package changjiashuai.github.io.rxjavatest.v4;

import android.net.Uri;

import java.util.List;

import changjiashuai.github.io.rxjavatest.v1.Cat;
import changjiashuai.github.io.rxjavatest.v3.Api;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/23 15:32.
 */
public class ApiWrapper {
    Api api;

    public void queryCats(String query, final Callback<List<Cat>> catsCallback){
        api.queryCats(query, new Api.CatsQueryCallback() {
            @Override
            public void onCatListReceived(List<Cat> cats) {
                catsCallback.onResult(cats);
            }

            @Override
            public void onQueryFailed(Exception e) {
                catsCallback.onError(e);
            }
        });
    }

    public void store(Cat cat, final Callback<Uri> uriCallback){
        api.store(cat, new Api.StoreCallback() {
            @Override
            public void onCatStored(Uri uri) {
                uriCallback.onResult(uri);
            }

            @Override
            public void onStoreFailed(Exception e) {
                uriCallback.onError(e);
            }
        });
    }
}
