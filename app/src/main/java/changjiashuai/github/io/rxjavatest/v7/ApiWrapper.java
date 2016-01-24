package changjiashuai.github.io.rxjavatest.v7;

import android.net.Uri;

import java.util.List;

import changjiashuai.github.io.rxjavatest.v1.Cat;
import changjiashuai.github.io.rxjavatest.v3.Api;
import rx.Observable;
import rx.Subscriber;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/24 00:32.
 */
public class ApiWrapper {
    Api api;

    public Observable<List<Cat>> queryCats(String query){
        return Observable.create(new Observable.OnSubscribe<List<Cat>>() {
            @Override
            public void call(Subscriber<? super List<Cat>> subscriber) {
                api.queryCats(query, new Api.CatsQueryCallback() {
                    @Override
                    public void onCatListReceived(List<Cat> cats) {
                        subscriber.onNext(cats);
                    }

                    @Override
                    public void onQueryFailed(Exception e) {
                        subscriber.onError(e);
                    }
                });
            }
        });
    }

    public Observable<Uri> store(Cat cat){
        return Observable.create(new Observable.OnSubscribe<Uri>() {
            @Override
            public void call(Subscriber<? super Uri> subscriber) {
                api.store(cat, new Api.StoreCallback() {
                    @Override
                    public void onCatStored(Uri uri) {
                        subscriber.onNext(uri);
                    }

                    @Override
                    public void onStoreFailed(Exception e) {
                        subscriber.onError(e);
                    }
                });
            }
        });
    }
}
