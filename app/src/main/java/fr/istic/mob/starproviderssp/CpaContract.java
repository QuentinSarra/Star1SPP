package fr.istic.mob.starproviderssp;

import android.net.Uri;
import android.provider.BaseColumns;

public class CpaContract {

    static String AUTHORITY = "fr.istic.mob.starproviderssp";
    Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
    static String CONTENT_PATH = "cpa";
    Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
    static String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.fr.istic.mob.starproviderssp.cpa";
    static String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.fr.istic.mob.starproviderssp.cpa";
    interface CpaColumns extends BaseColumns { String CPA_EDITOR = "editeur";}
}
