package edu.ptit.vhlee.moviedb.data.source.remote;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.ptit.vhlee.moviedb.data.source.MovieDataSource;

public class BaseAsyncTask extends AsyncTask<String, Void, String> {
    private Exception mException;
    private MovieDataSource.Callback mCallback;

    public BaseAsyncTask(MovieDataSource.Callback mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mCallback.onStart();
    }

    @Override
    protected String doInBackground(String... strings) {
        return readJson(strings[0]);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (mCallback == null) {
            return;
        }
        if (mException != null) {
            mCallback.onFail(mException);
        } else {
            mCallback.onSuccess(result);
            mCallback.onComplete();
        }
    }

    public String readJson(String url) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL m = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) m.openConnection();
            InputStreamReader input = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(input);
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            mException = e;
        }
        return stringBuilder.toString();
    }
}
