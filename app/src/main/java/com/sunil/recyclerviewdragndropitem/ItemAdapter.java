package com.sunil.recyclerviewdragndropitem;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by sunil on 27-Feb-16.
 */
public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchHelperAdapter {

    private List<ItemModel> mPersonList;
    OnItemClickListener mItemClickListener;
    private static final int TYPE_ITEM = 0;
    private final LayoutInflater mInflater;
    private final OnStartDragListener mDragStartListener;
    private Context mContext;

    public ItemAdapter(Context context, List<ItemModel> list, OnStartDragListener dragListner) {
        this.mPersonList = list;
        this.mInflater = LayoutInflater.from(context);
        mDragStartListener = dragListner;
        mContext = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        if (viewType == TYPE_ITEM) {
            //inflate your layout and pass it to view holder
            View v = mInflater.inflate(R.layout.person_item, viewGroup, false);
            return new VHItem(v );
        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");

    }

    @Override
    public int getItemViewType(int position) {
            return TYPE_ITEM;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {

        if (viewHolder instanceof VHItem) {

            final VHItem holder= (VHItem)viewHolder;
            ((VHItem) viewHolder).title.setText(mPersonList.get(i).getName());
            Picasso.with(mContext)
                    .load(mPersonList.get(i).getImagePath())
                    .placeholder(R.drawable.ic_profile)
                    .into(((VHItem) viewHolder).imageView);

            ((VHItem) viewHolder).image_menu.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                        mDragStartListener.onStartDrag(holder);
                    }
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public class VHItem extends RecyclerView.ViewHolder implements View.OnClickListener ,ItemTouchHelperViewHolder{
        public TextView title;
        private ImageView imageView;
        private ImageView image_menu;

        public VHItem(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.name);
            image_menu = (ImageView) itemView.findViewById(R.id.image_menu);
            imageView = (ImageView) itemView.findViewById(R.id.circle_imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getPosition());
            }
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }

    @Override
    public void onItemDismiss(int position) {
        mPersonList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        //Log.v("", "Log position" + fromPosition + " " + toPosition);
        if (fromPosition < mPersonList.size() && toPosition < mPersonList.size()) {
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(mPersonList, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(mPersonList, i, i - 1);
                }
            }
            notifyItemMoved(fromPosition, toPosition);
        }
        return true;
    }

    public void updateList(List<ItemModel> list) {
        mPersonList = list;
        notifyDataSetChanged();
    }
}