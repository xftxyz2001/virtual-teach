package com.xftxyz.virtualteach.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xftxyz.virtualteach.client.R;
import com.xftxyz.virtualteach.client.domain.SystemNotification;

import java.util.List;

public class NotificationAdapter extends BaseAdapter {
    private List<SystemNotification> notificationList;
    private LayoutInflater inflater;

    public NotificationAdapter(Context context, List<SystemNotification> notificationList) {
        this.notificationList = notificationList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return notificationList.size();
    }

    @Override
    public SystemNotification getItem(int position) {
        return notificationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.notification_item, parent, false);
            holder = new ViewHolder();
            holder.tvType = convertView.findViewById(R.id.tv_notification_item_type);
            holder.tvTopic = convertView.findViewById(R.id.tv_notification_item_topic);
            holder.tvDate = convertView.findViewById(R.id.tv_notification_item_release_time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        SystemNotification notification = notificationList.get(position);
        holder.tvType.setText(notification.getNotificationType());
        holder.tvTopic.setText(notification.getTopic());
        holder.tvDate.setText(notification.getCreateTime().toString());

        return convertView;
    }

    static class ViewHolder {
        TextView tvType;
        TextView tvTopic;
        TextView tvDate;
    }
}
