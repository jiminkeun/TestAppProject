package mytest.syscore.daou.mytest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import mytest.syscore.daou.mytest.R;
import mytest.syscore.daou.mytest.item.MemberInfo;

/**
 * Created by daou on 2017-11-21.
 */

public class MemberInfoAdapter extends BaseAdapter{
    private ArrayList<MemberInfo> listMember = new ArrayList<MemberInfo>();

    public MemberInfoAdapter() {
    }

    @Override
    public int getCount() {
        return listMember.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listMember.get(position);
    }

    // 신규등록
    public void addItem(int no, String name, int age, String sex, String birthday, String job, String addr) {
        MemberInfo info = new MemberInfo();

        info.setNo(no);
        info.setName(name);
        info.setAge(age);
        info.setSex(sex);
        info.setBirthday(birthday);
        info.setJob(job);
        info.setAddr(addr);

        listMember.add(info);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_member_info, parent, false);
        }

        // 화면 표시
        TextView no = (TextView) convertView.findViewById(R.id.customMemberNo);
        TextView name = (TextView) convertView.findViewById(R.id.customMemberName);
        TextView age = (TextView) convertView.findViewById(R.id.customMemberAge);
        TextView sex = (TextView) convertView.findViewById(R.id.customMemberSex);
        TextView birthday = (TextView) convertView.findViewById(R.id.customMemberBirthday);
        TextView job = (TextView) convertView.findViewById(R.id.customMemberJob);
        TextView addr = (TextView) convertView.findViewById(R.id.customMemberAddr);

        MemberInfo memberInfo = listMember.get(position);

        no.setText(memberInfo.getNo());
        name.setText(memberInfo.getName());
        age.setText(memberInfo.getAge());
        sex.setText(memberInfo.getSex());
        birthday.setText(memberInfo.getBirthday());
        job.setText(memberInfo.getJob());
        addr.setText(memberInfo.getAddr());

        return convertView;
    }


}
