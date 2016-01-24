package changjiashuai.github.io.rxjavatest.v2;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

import changjiashuai.github.io.rxjavatest.v1.Cat;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/23 15:18.
 */
public class CatsHelper {

    public interface CutestCatCallback{
        void onCutestCatSaved(Uri uri);
        void onQueryFailed(Exception e);
    }

    Api api;

    public void saveTheCutestCat(String query, final CutestCatCallback cutestCatCallback){
        api.queryCats(query, new Api.CatsQueryCallback() {
            @Override
            public void onCatListReceived(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                Uri savedUri = api.store(cutest);
                cutestCatCallback.onCutestCatSaved(savedUri);
            }

            @Override
            public void onError(Exception e) {
                cutestCatCallback.onQueryFailed(e);
            }
        });
    }

    private Cat findCutest(List<Cat> cats){
        return Collections.max(cats);
    }
}
