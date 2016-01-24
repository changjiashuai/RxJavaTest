package changjiashuai.github.io.rxjavatest.v6;

import android.net.Uri;

import java.util.Collections;
import java.util.List;

import changjiashuai.github.io.rxjavatest.v1.Cat;
import changjiashuai.github.io.rxjavatest.v4.Callback;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/1/24 00:11.
 */
public class CatsHelper {
    ApiWrapper apiWrapper;

    public AsyncJob<Uri> saveTheCutestCat(String query) {
        AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper.queryCats(query);
        final AsyncJob<Cat> cutestCatAsyncJob = catsListAsyncJob.map(new Func<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                return findCutest(cats);
            }
        });

        AsyncJob<Uri> storedUriAsyncJob = new AsyncJob<Uri>() {
            @Override
            public void start(final Callback<Uri> callback) {
                cutestCatAsyncJob.start(new Callback<Cat>() {
                    @Override
                    public void onResult(Cat cutest) {
                        apiWrapper.store(cutest)
                                .start(new Callback<Uri>() {
                                    @Override
                                    public void onResult(Uri result) {
                                        callback.onResult(result);
                                    }

                                    @Override
                                    public void onError(Exception e) {
                                        callback.onError(e);
                                    }
                                });
                    }

                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
        return storedUriAsyncJob;
    }

    public AsyncJob<Uri> saveTheCutestCat2(String query) {
        AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper.queryCats(query);
        final AsyncJob<Cat> cutestCatAsyncJob = catsListAsyncJob.map(new Func<List<Cat>, Cat>() {
            @Override
            public Cat call(List<Cat> cats) {
                return findCutest(cats);
            }
        });

        return cutestCatAsyncJob.flatMap(new Func<Cat, AsyncJob<Uri>>() {
            @Override
            public AsyncJob<Uri> call(Cat cat) {
                return apiWrapper.store(cat);
            }
        });
    }

    public AsyncJob<Uri> saveTheCutestCat3(String query) {
        AsyncJob<List<Cat>> catsListAsyncJob = apiWrapper.queryCats(query);
        AsyncJob<Cat> cutestCatAsyncJob = catsListAsyncJob.map(this::findCutest);
        return cutestCatAsyncJob.flatMap(apiWrapper::store);
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
