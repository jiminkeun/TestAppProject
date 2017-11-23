package mytest.syscore.daou.mytest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mytest.syscore.daou.mytest.R;
import mytest.syscore.daou.mytest.item.MemberInfo;

/**
 * Created by daou on 2017-11-21.
 */

public class MemberInfoAdapter extends ArrayAdapter<MemberInfo>{
    //private ArrayList<MemberInfo> listMember = new ArrayList<MemberInfo>();
    private ViewHolder mViewHolder = null;
    private LayoutInflater mInflater = null;

    class ViewHolder {
        public TextView no = null;
        public TextView name = null;
        public TextView age = null;
        public TextView sex = null;
        public TextView birthday = null;
        public TextView job = null;
        public TextView addr = null;
    }

    public MemberInfoAdapter(Context context, int resource, List<MemberInfo> info) {
        super(context, resource, info);

        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null) {
            mViewHolder = new ViewHolder();
            v = mInflater.inflate(R.layout.listview_member_info, null);

            mViewHolder.no = (TextView) v.findViewById(R.id.customMemberNo);
            mViewHolder.name = (TextView) v.findViewById(R.id.customMemberName);
            mViewHolder.age = (TextView) v.findViewById(R.id.customMemberAge);
            mViewHolder.sex = (TextView) v.findViewById(R.id.customMemberSex);
            mViewHolder.birthday = (TextView) v.findViewById(R.id.customMemberBirthday);
            mViewHolder.job = (TextView) v.findViewById(R.id.customMemberJob);
            mViewHolder.addr = (TextView) v.findViewById(R.id.customMemberAddr);

            v.setTag(mViewHolder);
        }else{
            mViewHolder = (ViewHolder) v.getTag();
        }

        mViewHolder.no.setText(getItem(position).getNo());
        mViewHolder.name.setText(getItem(position).getName());
        mViewHolder.age.setText(getItem(position).getAge());
        mViewHolder.sex.setText(getItem(position).getSex());
        mViewHolder.birthday.setText(getItem(position).getBirthday());
        mViewHolder.job.setText(getItem(position).getJob());
        mViewHolder.addr.setText(getItem(position).getAddr());

        return v;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public MemberInfo getItem(int position) {
        return super.getItem(position);
    }

}
