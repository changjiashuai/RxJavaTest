package changjiashuai.github.io.rxjavatest.v3;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

import changjiashuai.github.io.rxjavatest.v1.Cat;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/23 15:26.
 */
public class CatsHelper {

    public interface CutestCatCallback{
        void onCutestCatSaved(Uri uri);
        void onError(Exception e);
    }

    Api api;

    public void saveTheCutestCat(String query, final CutestCatCallback cutestCatCallback){
        api.queryCats(query, new Api.CatsQueryCallback() {
            @Override
            public void onCatListReceived(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                api.store(cutest, new Api.StoreCallback() {
                    @Override
                    public void onCatStored(Uri uri) {
                        cutestCatCallback.onCutestCatSaved(uri);
                    }

                    @Override
                    public void onStoreFailed(Exception e) {
                        cutestCatCallback.onError(e);
                    }
                });
            }

            @Override
            public void onQueryFailed(Exception e) {
                cutestCatCallback.onError(e);
            }
        });
    }

    private Cat findCutest(List<Cat> cats){
        return Collections.max(cats);
    }
}
