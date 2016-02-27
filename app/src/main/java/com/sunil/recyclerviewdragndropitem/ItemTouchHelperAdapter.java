package com.sunil.recyclerviewdragndropitem;

/**
 * Created by sunil on 27-Feb-16.
 */
public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}

