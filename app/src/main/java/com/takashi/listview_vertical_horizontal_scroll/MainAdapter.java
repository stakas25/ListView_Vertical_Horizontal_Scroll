package com.takashi.listview_vertical_horizontal_scroll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private Context mContext;
    private ViewHolder mViewHolder;

    public MainAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view != null) mViewHolder = (ViewHolder) view.getTag();
        else {
            view = mInflater.inflate(R.layout.item_main, viewGroup, false);
            mViewHolder = new ViewHolder(view);
            view.setTag(mViewHolder);
        }
        mViewHolder.v1.setOnClickListener(v -> Toast.makeText(mContext, i + "番目のTextView1が押されました", Toast.LENGTH_SHORT).show());
        mViewHolder.v1.setOnClickListener(v -> Toast.makeText(mContext, i + "番目のTextView2が押されました", Toast.LENGTH_SHORT).show());

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.v1)
        TextView v1;
        @BindView(R.id.v2)
        TextView v2;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
