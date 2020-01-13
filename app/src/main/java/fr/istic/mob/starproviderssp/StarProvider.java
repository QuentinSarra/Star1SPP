package fr.istic.mob.starproviderssp;

import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import fr.istic.mob.starproviderssp.database.DB_Starprovider;

public class StarProvider extends ContentProvider {

    String AUTHORITY = "fr.istic.mob.starproviderssp";

    Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
    private static final int BusRoutes = 1;
    private static final int Stops = 2;
    private static final int StopTimes = 3;
    private static final int trips = 4;
    private static final int JOIN_DIR_TYPE1 = 10;
    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);



    static {
        URI_MATCHER.addURI(StarContract.AUTHORITY, StarContract.BusRoutes.CONTENT_PATH, BusRoutes);
        URI_MATCHER.addURI(StarContract.AUTHORITY, StarContract.Stops.CONTENT_PATH, Stops);
        URI_MATCHER.addURI(StarContract.AUTHORITY, StarContract.StopTimes.CONTENT_PATH , StopTimes);
        URI_MATCHER.addURI(StarContract.AUTHORITY, StarContract.Trips.CONTENT_PATH,trips);
        URI_MATCHER.addURI(StarContract.AUTHORITY, StarContract.Join1.CONTENT_PATH, JOIN_DIR_TYPE1);

    }/*
    private Cursor queryJoin(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder, SQLiteDatabase database){
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables("stop LEFT OUTER JOIN stoptime ON (stop.stop_code = stoptime.stop_code)");
        return database.query(uri.getLastPathSegment(), projection, selection, selectionArgs, null, null, sortOrder);
    }*/

    @Override
    public boolean onCreate() {
        return false;

    }


    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        DB_Starprovider helper = new DB_Starprovider(getContext());
        SQLiteDatabase database = helper.getReadableDatabase();
        switch (URI_MATCHER.match(uri)) {/*
            case JOIN_DIR_TYPE1:
                return queryJoin(uri,projection,selection,selectionArgs,sortOrder,database);*/
            default:
                return database.query(uri.getLastPathSegment(), projection, selection, selectionArgs, null, null, sortOrder);
        }
    }


    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
