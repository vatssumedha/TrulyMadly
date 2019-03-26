package com.trulyassignment.view.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.trulyassignment.R;
import com.trulyassignment.model.InformationList;
import com.trulyassignment.model.InformationResponse;

import java.util.ArrayList;

/**
 * Created by Sumedha Vats on 26-03-2019.
 */
public class InfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<InformationList> informationList;
    Context mContext;

    public static class CompatibilityQues extends RecyclerView.ViewHolder {


        ImageView imgMedium;
        TextView id;
        TextView question;
        TextView tick;
        TextView cross;

        public CompatibilityQues(View itemView) {
            super(itemView);

            this.imgMedium = itemView.findViewById(R.id.imgMedium);
            this.id = itemView.findViewById(R.id.id);
            this.question = itemView.findViewById(R.id.question);
            this.tick = itemView.findViewById(R.id.tick);
            this.cross = itemView.findViewById(R.id.cross);

        }

    }

    public static class ProfileQues extends RecyclerView.ViewHolder {


        TextView id;
        TextView question;
        TextView suggestion;

        public ProfileQues(View itemView) {
            super(itemView);

            this.id = itemView.findViewById(R.id.id);
            this.question = itemView.findViewById(R.id.question);
            this.suggestion = itemView.findViewById(R.id.suggestion);

        }

    }

    public static class SimpleText extends RecyclerView.ViewHolder {


        TextView text;

        public SimpleText(View itemView) {
            super(itemView);

            this.text = itemView.findViewById(R.id.text);

        }

    }

    public static class Orientation extends RecyclerView.ViewHolder {


        TextView id;
        TextView name;

        public Orientation(View itemView) {
            super(itemView);

            this.id = itemView.findViewById(R.id.id);
            this.name = itemView.findViewById(R.id.name);

        }

    }

    public static class GroupLeave extends RecyclerView.ViewHolder {


        TextView id;
        TextView name;
        TextView type;

        public GroupLeave(View itemView) {
            super(itemView);

            this.id = itemView.findViewById(R.id.id);
            this.name = itemView.findViewById(R.id.name);
            this.type = itemView.findViewById(R.id.type);

        }

    }

    public static class UserUnmatch extends RecyclerView.ViewHolder {


        TextView rank;
        TextView id;
        TextView name;
        TextView type;
        TextView created_at;
        TextView updated_at;

        public UserUnmatch(View itemView) {
            super(itemView);

            this.rank = itemView.findViewById(R.id.rank);
            this.id = itemView.findViewById(R.id.id);
            this.name = itemView.findViewById(R.id.name);
            this.type = itemView.findViewById(R.id.type);
            this.created_at = itemView.findViewById(R.id.created_at);
            this.updated_at = itemView.findViewById(R.id.updated_at);

        }

    }

    public static class UserDeleteDeactivate extends RecyclerView.ViewHolder {


        TextView reason;
        TextView next_action_text;
        TextView click_action;


        public UserDeleteDeactivate(View itemView) {
            super(itemView);

            this.reason = itemView.findViewById(R.id.reason);
            this.next_action_text = itemView.findViewById(R.id.next_action_text);
            this.click_action = itemView.findViewById(R.id.click_action);


        }

    }

    public static class ImageSpark extends RecyclerView.ViewHolder {


        ImageView imgSpark;


        public ImageSpark(View itemView) {
            super(itemView);

            this.imgSpark = itemView.findViewById(R.id.imgSpark);


        }

    }

    public InfoAdapter(ArrayList<InformationList> informationList, Context context) {
        this.informationList = informationList;
        this.mContext = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case InformationList.TYPE_COMP_QUES:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_compatibility_question, parent, false);
                return new CompatibilityQues(view);
            case InformationList.TYPE_PRO_QUES:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_profile_question, parent, false);
                return new ProfileQues(view);
            case InformationList.TYPE_STRING_LIST:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_single_text, parent, false);
                return new SimpleText(view);
            case InformationList.TYPE_ORIENTATION:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_orientation, parent, false);
                return new Orientation(view);
            case InformationList.TYPE_GRP_LEAVE_REASON:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_grp_leave_reason, parent, false);
                return new GroupLeave(view);
            case InformationList.TYPE_USER_UNMATCH_REASON:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_user_unmatch_reason, parent, false);
                return new UserUnmatch(view);
            case InformationList.TYPE_DEAC_DEL_REASON:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_deactivate_delete_reason, parent, false);
                return new UserDeleteDeactivate(view);
            case InformationList.TYPE_STATIC_IMG:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_image, parent, false);
                return new ImageSpark(view);
            case InformationList.TYPE_STRING:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_single_text, parent, false);
                return new SimpleText(view);
        }
        return null;


    }


    @Override
    public int getItemViewType(int position) {

        switch (informationList.get(position).viewType) {
            case 0:
                return InformationList.TYPE_COMP_QUES;
            case 1:
                return InformationList.TYPE_PRO_QUES;
            case 2:
                return InformationList.TYPE_STRING_LIST;
            case 3:
                return InformationList.TYPE_ORIENTATION;
            case 4:
                return InformationList.TYPE_GRP_LEAVE_REASON;
            case 5:
                return InformationList.TYPE_USER_UNMATCH_REASON;
            case 6:
                return InformationList.TYPE_DEAC_DEL_REASON;
            case 7:
                return InformationList.TYPE_STATIC_IMG;
            case 8:
                return InformationList.TYPE_STRING;
            default:
                return -1;
        }


    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        InformationList info = informationList.get(listPosition);
        if (info != null) {
            switch (info.viewType) {
                case InformationList.TYPE_COMP_QUES:
                    ((CompatibilityQues) holder).id.setText(String.valueOf(info.compatibilityQuestions.getId()));
                    ((CompatibilityQues) holder).question.setText(info.compatibilityQuestions.getQuestion());
                    ((CompatibilityQues) holder).tick.setText(info.compatibilityQuestions.getTick());
                    ((CompatibilityQues) holder).cross.setText(info.compatibilityQuestions.getCross());
                   //Image url is showing access denied
                    Picasso.with(mContext).load(info.compatibilityQuestions.getStyle().getThumb()).placeholder(R.drawable.ic_launcher_foreground).into(((CompatibilityQues) holder).imgMedium);
                    break;
                case InformationList.TYPE_PRO_QUES:
                    ((ProfileQues) holder).id.setText(String.valueOf(info.profileQuestions.getId()));
                    ((ProfileQues) holder).question.setText(info.profileQuestions.getQuestion());
                    ((ProfileQues) holder).suggestion.setText(info.profileQuestions.getSuggestion());
                    break;
                case InformationList.TYPE_STRING_LIST:
                    ((SimpleText) holder).text.setText(info.stringsList);
                    break;
                case InformationList.TYPE_ORIENTATION:
                    ((Orientation) holder).id.setText(String.valueOf(info.orientations.getId()));
                    ((Orientation) holder).name.setText(info.orientations.getName());
                    break;
                case InformationList.TYPE_GRP_LEAVE_REASON:
                    ((GroupLeave) holder).id.setText(String.valueOf(info.groupLeaveReportReasons.getId()));
                    ((GroupLeave) holder).name.setText(info.groupLeaveReportReasons.getName());
                    ((GroupLeave) holder).type.setText(info.groupLeaveReportReasons.getType());
                    break;
                case InformationList.TYPE_USER_UNMATCH_REASON:
                    ((UserUnmatch) holder).id.setText(String.valueOf(info.userUnmatchReportReasons.getId()));
                    ((UserUnmatch) holder).name.setText(info.userUnmatchReportReasons.getName());
                    ((UserUnmatch) holder).rank.setText(String.valueOf(info.userUnmatchReportReasons.getRank()));
                    ((UserUnmatch) holder).created_at.setText(info.userUnmatchReportReasons.getCreated_at());
                    ((UserUnmatch) holder).updated_at.setText(info.userUnmatchReportReasons.getUpdated_at());
                    ((UserUnmatch) holder).type.setText(info.userUnmatchReportReasons.getType());
                    break;
                case InformationList.TYPE_DEAC_DEL_REASON:
                    ((UserDeleteDeactivate) holder).reason.setText(info.deactivationDeleteReasons.getReason());
                    ((UserDeleteDeactivate) holder).click_action.setText(info.deactivationDeleteReasons.getClick_action());
                    ((UserDeleteDeactivate) holder).next_action_text.setText(info.deactivationDeleteReasons.getNext_action_text());
                    break;
                case InformationList.TYPE_STATIC_IMG:
                    Picasso.with(mContext).load(info.staticImages.getSpark()).into(((ImageSpark) holder).imgSpark);
                    break;
                case InformationList.TYPE_STRING:
                    if (info.share_app_link != null) {
                        ((SimpleText) holder).text.setText(info.share_app_link);

                    } else {
                        ((SimpleText) holder).text.setText(info.share_app_text);

                    }
                    break;

            }
        }

    }

    @Override
    public int getItemCount() {
        return informationList.size();
    }


}
