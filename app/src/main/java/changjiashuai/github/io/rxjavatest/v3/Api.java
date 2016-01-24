package changjiashuai.github.io.rxjavatest.v3;

import android.net.Uri;

import java.util.List;

import changjiashuai.github.io.rxjavatest.v1.Cat;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/23 15:24.
 */
public interface Api {
    interface CatsQueryCallback{
        void onCatListReceived(List<Cat> cats);
        void onQueryFailed(Exception e);
    }

    interface StoreCallback{
        void onCatStored(Uri uri);
        void onStoreFailed(Exception e);
    }

    void queryCats(String query, CatsQueryCallback catsQueryCallback);
    void store(Cat cat, StoreCallback storeCallback);
}
