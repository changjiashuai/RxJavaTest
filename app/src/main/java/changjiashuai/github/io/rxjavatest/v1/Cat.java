package changjiashuai.github.io.rxjavatest.v1;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/23 15:08.
 */
public class Cat implements Comparable<Cat> {
    Bitmap image;
    int cuteness;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public int compareTo(Cat another) {
        return Integer.compare(cuteness, another.cuteness);
    }
}
