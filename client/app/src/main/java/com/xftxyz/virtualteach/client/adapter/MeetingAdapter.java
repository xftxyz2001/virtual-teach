package com.xftxyz.virtualteach.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xftxyz.virtualteach.client.R;
import com.xftxyz.virtualteach.client.domain.Meeting;

import java.util.List;

public class MeetingAdapter extends BaseAdapter {
    private List<Meeting> meetingList;
    private LayoutInflater inflater;

    public MeetingAdapter(Context context, List<Meeting> meetingList) {
        this.meetingList = meetingList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return meetingList.size();
    }

    @Override
    public Meeting getItem(int position) {
        return meetingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.meeting_item, parent, false);
            holder = new ViewHolder();
            holder.tvTopic = convertView.findViewById(R.id.tv_meeting_item_topic);
            holder.tvDate = convertView.findViewById(R.id.tv_meeting_item_start_time);
            holder.TvNum = convertView.findViewById(R.id.tv_meeting_item_num);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Meeting meeting = meetingList.get(position);
        holder.tvTopic.setText(meeting.getTopic());
        holder.tvDate.setText(meeting.getStartTime().toString());
        holder.TvNum.setText(meeting.getInviteNum());

        return convertView;
    }

    static class ViewHolder {
        TextView tvTopic;
        TextView tvDate;
        TextView TvNum;
    }

}
