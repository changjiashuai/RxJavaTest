package changjiashuai.github.io.rxjavatest.v1;

import android.net.Uri;

import java.util.List;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/23 15:10.
 */
public interface Api {
    List<Cat> queryCats(String query);
    Uri store(Cat cat);
}
