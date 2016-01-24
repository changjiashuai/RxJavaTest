package changjiashuai.github.io.rxjavatest.v2;

import android.net.Uri;

import java.util.List;

import changjiashuai.github.io.rxjavatest.v1.Cat;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/23 15:17.
 */
public interface Api {
    interface CatsQueryCallback{
        void onCatListReceived(List<Cat> cats);
        void onError(Exception e);
    }

    void queryCats(String query, CatsQueryCallback catsQueryCallback);
    Uri store(Cat cat);
}
