package fr.istic.mob.starproviderssp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CpaProvider extends ContentProvider {

    private static final int QUERY_ALL_CPA = 1;
    private static final int QUERY_BY_CPA_ID = 2;
    private static final UriMatcher URI_MATCHER =
        new UriMatcher(UriMatcher.NO_MATCH);
    static {
        URI_MATCHER.addURI(CpaContract.AUTHORITY, CpaContract.CONTENT_PATH, QUERY_ALL_CPA);
        URI_MATCHER.addURI(CpaContract.AUTHORITY, CpaContract.CONTENT_PATH + "/#", QUERY_BY_CPA_ID);
        }
    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(@NonNull Uri uri,
                        @Nullable String[] projection,
                        @Nullable String selection,
                        @Nullable String[] selectionArgs,
                        @Nullable String sortOrder){

        return null;
    }

    @Nullable @Override
    public String getType(@NonNull Uri uri) {
        switch (URI_MATCHER.match(uri)) {
            case QUERY_ALL_CPA: return CpaContract.CONTENT_TYPE;
            case QUERY_BY_CPA_ID:
                return CpaContract.CONTENT_ITEM_TYPE;
            default: return null;
        }
    }
    @Nullable @Override
    public Uri insert(@NonNull Uri uri,
    @Nullable ContentValues values) {
        return uri;
    }
    @Override
    public int delete(@NonNull Uri uri,
    @Nullable String selection,
    @Nullable String[] selectionArgs)
    throws SQLException {
        return 0;
    }
    @Override
    public int update(@NonNull Uri uri,
    @Nullable ContentValues values,
    @Nullable String selection,
    @Nullable String[] selectionArgs) {
        return 0;
    }
}
