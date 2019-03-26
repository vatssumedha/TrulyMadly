package com.trulyassignment.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.trulyassignment.R;
import com.trulyassignment.model.InformationList;
import com.trulyassignment.model.InformationResponse;
import com.trulyassignment.view.adapters.InfoAdapter;
import com.trulyassignment.viewmodel.InformationViewModel;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        InformationViewModel model = ViewModelProviders.of(this).get(InformationViewModel.class);

        model.getInfo().observe(this, new Observer<InformationResponse>() {
            @Override
            public void onChanged(@Nullable InformationResponse informationResponse) {
                initView(informationResponse);
            }
        });


    }

    public void initView(InformationResponse informationResponse) {

        ArrayList<InformationList> infoList = new ArrayList<>();
        for (int a = 0; a < informationResponse.getCompatibility_questions().size(); a++) {
            infoList.add(new InformationList(InformationList.TYPE_COMP_QUES, informationResponse.getCompatibility_questions().get(a), null, null, null, null, null, null, null, null, null));

        }
        for (int a = 0; a < informationResponse.getProfile_questions().size(); a++) {
            infoList.add(new InformationList(InformationList.TYPE_PRO_QUES, null, informationResponse.getProfile_questions().get(a), null, null, null, null, null, null, null, null));

        }
        for (int a = 0; a < informationResponse.getHiv_statuses().size(); a++) {
            infoList.add(new InformationList(InformationList.TYPE_STRING_LIST, null, null, null, null, null, informationResponse.getHiv_statuses().get(a), null, null, null, null));

        }
        for (int a = 0; a < informationResponse.getTribes().size(); a++) {
            infoList.add(new InformationList(InformationList.TYPE_STRING_LIST, null, null, null, null, null, informationResponse.getTribes().get(a), null, null, null, null));

        }
        for (int a = 0; a < informationResponse.getInterests().size(); a++) {
            infoList.add(new InformationList(InformationList.TYPE_STRING_LIST, null, null, null, null, null, informationResponse.getInterests().get(a), null, null, null, null));

        }
        for (int a = 0; a < informationResponse.getOrientations().size(); a++) {
            infoList.add(new InformationList(InformationList.TYPE_ORIENTATION, null, null, informationResponse.getOrientations().get(a), null, null, null, null, null, null, null));

        }
        for (int a = 0; a < informationResponse.getGroup_leave_reasons().size(); a++) {
            infoList.add(new InformationList(InformationList.TYPE_GRP_LEAVE_REASON, null, null, null, informationResponse.getGroup_leave_reasons().get(a), null, null, null, null, null, null));

        }
        for (int a = 0; a < informationResponse.getGroup_report_reasons().size(); a++) {
            infoList.add(new InformationList(InformationList.TYPE_GRP_LEAVE_REASON, null, null, null, informationResponse.getGroup_report_reasons().get(a), null, null, null, null, null, null));

        }


        for (int a = 0; a < informationResponse.getUser_unmatch_reasons().size(); a++) {
            infoList.add(new InformationList(InformationList.TYPE_USER_UNMATCH_REASON, null, null, null, null, null, null, informationResponse.getUser_unmatch_reasons().get(a), null, null, null));
        }
        for (int a = 0; a < informationResponse.getUser_report_reasons().size(); a++) {
            infoList.add(new InformationList(InformationList.TYPE_USER_UNMATCH_REASON, null, null, null, null, null, null, informationResponse.getUser_report_reasons().get(a), null, null, null));
        }
        for (int a = 0; a < informationResponse.getUser_group_report_reasons().size(); a++) {
            infoList.add(new InformationList(InformationList.TYPE_USER_UNMATCH_REASON, null, null, null, null, null, null, informationResponse.getUser_group_report_reasons().get(a), null, null, null));
        }
        for (int a = 0; a < informationResponse.getDeactivation_reasons().size(); a++) {
            infoList.add(new InformationList(InformationList.TYPE_DEAC_DEL_REASON, null, null, null, null, null, null, null, informationResponse.getDeactivation_reasons().get(a), null, null));
        }
        for (int a = 0; a < informationResponse.getDeletion_reasons().size(); a++) {
            infoList.add(new InformationList(InformationList.TYPE_DEAC_DEL_REASON, null, null, null, null, null, null, null, informationResponse.getDeletion_reasons().get(a), null, null));
        }
        infoList.add(new InformationList(InformationList.TYPE_STATIC_IMG, null, null, null, null, informationResponse.getStatic_images(), null, null, null, null, null));
        infoList.add(new InformationList(InformationList.TYPE_STRING, null, null, null, null, null, null, null, null, informationResponse.getShare_app_text(), null));
        infoList.add(new InformationList(InformationList.TYPE_STRING, null, null, null, null, null, null, null, null, null, informationResponse.getShare_app_link()));


        InfoAdapter adapter = new InfoAdapter(infoList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);
    }



}
