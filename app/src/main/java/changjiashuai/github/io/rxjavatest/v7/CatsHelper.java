package changjiashuai.github.io.rxjavatest.v7;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

import changjiashuai.github.io.rxjavatest.v1.Cat;
import rx.Observable;
import rx.functions.Func1;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/24 00:32.
 */
public class CatsHelper {
    ApiWrapper apiWrapper;

    public Observable<Uri> saveTheCutestCat(String query){
        Observable<List<Cat>> catsListObservable = apiWrapper.queryCats(query);
        Observable<Cat> cutestCatObservable = catsListObservable.map(new Func1<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                return findCutest(cats);
            }
        });
        Observable<Uri> storedUriObservalbe = cutestCatObservable.flatMap(new Func1<Cat, Observable<? extends Uri>>() {
            @Override
            public Observable<Uri> call(Cat cat) {
                return apiWrapper.store(cat);
            }
        });
        return storedUriObservalbe;
    }

    private Cat findCutest(List<Cat> cats){
        return Collections.max(cats);
    }
}
