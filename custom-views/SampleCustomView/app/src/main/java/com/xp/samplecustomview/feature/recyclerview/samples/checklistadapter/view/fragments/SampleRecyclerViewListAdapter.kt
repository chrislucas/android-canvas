package com.xp.samplecustomview.feature.recyclerview.samples.checklistadapter.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplecustomview.R
import com.xp.samplecustomview.commons.view.recyclerview.action.DefaultSimpleBindViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.action.VIEW_HOLDER_MOCK_USERS_LIST_ADAPTER
import com.xp.samplecustomview.commons.view.recyclerview.adapter.GenRecyclerViewWithListAdapter
import com.xp.samplecustomview.feature.galleryoffeatures.models.CompositeRecyclerViewItem
import com.xp.samplecustomview.feature.galleryoffeatures.view.adapters.recyclerview.viewholders.ListenerFeaturesViewHolder
import com.xp.samplecustomview.feature.recyclerview.samples.checklistadapter.models.ComparatorUserByAge
import com.xp.samplecustomview.feature.recyclerview.samples.checklistadapter.models.User
import com.xp.samplecustomview.feature.recyclerview.samples.checklistadapter.view.list.diffdata.providerDiffCallback
import com.xp.samplecustomview.feature.recyclerview.samples.checklistadapter.view.list.models.BindUserItem
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment

class SampleRecyclerViewListAdapter : Fragment(), ListenerFeaturesViewHolder {

    private val users = mutableListOf(
        CompositeRecyclerViewItem(
            VIEW_HOLDER_MOCK_USERS_LIST_ADAPTER,
            User("Chris", 31),
            BindUserItem()
        ),
        CompositeRecyclerViewItem(
            VIEW_HOLDER_MOCK_USERS_LIST_ADAPTER,
            User("Chris", 21),
            BindUserItem()
        ),
        CompositeRecyclerViewItem(
            VIEW_HOLDER_MOCK_USERS_LIST_ADAPTER,
            User("Laura", 15),
            BindUserItem()
        ),
        CompositeRecyclerViewItem(
            VIEW_HOLDER_MOCK_USERS_LIST_ADAPTER,
            User("Philippe", 23),
            BindUserItem()
        ),
        CompositeRecyclerViewItem(
            VIEW_HOLDER_MOCK_USERS_LIST_ADAPTER,
            User("Andrezza", 23),
            BindUserItem()
        ),
        CompositeRecyclerViewItem(
            VIEW_HOLDER_MOCK_USERS_LIST_ADAPTER,
            User("Andressa", 27),
            BindUserItem()
        )
    )

    private val comparatorByAge: DiffUtil.ItemCallback<User> by lazy {
        providerDiffCallback(ComparatorUserByAge())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(
            R.layout.fragment_sample_recycler_view_list_adapter,
            container,
            false
        )

        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = GenRecyclerViewWithListAdapter(
                    users,
                    DefaultSimpleBindViewHolder(),
                    comparatorByAge
                )
            }
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = SampleRecyclerViewListAdapter()
    }

    override fun onInteractWithView(behaviorFragment: BaseBehaviorFragment) {}
}