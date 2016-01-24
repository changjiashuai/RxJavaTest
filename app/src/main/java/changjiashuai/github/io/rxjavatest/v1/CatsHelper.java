package changjiashuai.github.io.rxjavatest.v1;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/23 15:11.
 */
public class CatsHelper {
    Api api;

    public Uri saveTheCutestCat(String query) {
        try {
            List<Cat> cats = api.queryCats(query);
            Cat cutest = findCutest(cats);
            Uri savedUri = api.store(cutest);
            return savedUri;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // demo1
//    public Uri saveTheCutestCat(String query) {
//        List<Cat> cats = api.queryCats(query);
//        Cat cutest = findCutest(cats);
//        Uri savedUri = api.store(cutest);
//        return savedUri;
//    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}