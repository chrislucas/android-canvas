package com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.xp.samplecustomview.commons.ext.ownTag
import com.xp.samplecustomview.commons.view.recyclerview.action.DefaultSimpleBindViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.action.ListenerListFragmentsViewHolder
import com.xp.samplecustomview.commons.view.recyclerview.adapter.GenRecyclerView
import com.xp.samplecustomview.databinding.FragmentTypeOfBottomSheetsBinding
import com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.models.MetadataBottomSheet
import com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.models.OnClickBottomSheet
import com.xp.samplecustomview.feature.bottomsheet.typeofbottomsheet.models.providerTypesOfBottomSheet
import com.xp.samplecustomview.feature.galleryoffeatures.models.CompositeRecyclerViewItem
import com.xp.samplecustomview.helper.fragments.BaseBehaviorFragment
import com.xp.samplecustomview.helper.fragments.ChannelCommunicationFragmentActivity

class TypeOfBottomSheetsFragment : Fragment(), BaseBehaviorFragment,
    ListenerListFragmentsViewHolder {

    private lateinit var bindView: FragmentTypeOfBottomSheetsBinding
    private var channelCommunicationFragmentActivity: ChannelCommunicationFragmentActivity? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        bindView = FragmentTypeOfBottomSheetsBinding.inflate(layoutInflater)
        if (context is ChannelCommunicationFragmentActivity) {
            channelCommunicationFragmentActivity = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        val listenerListViewHolder = this
        with(bindView.rcTypeOfBottomSheet) {
            layoutManager = GridLayoutManager(context, 2)
            adapter = GenRecyclerView(
                providerTypesOfBottomSheet(listenerListViewHolder),
                DefaultSimpleBindViewHolder()
            )
        }

        return bindView.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = TypeOfBottomSheetsFragment()
    }

    override fun getMyOwnTag(): String = this.javaClass.ownTag

    override fun getInstanceFragment(): Fragment = this

    override fun actionOnBackPressedInFragment() {}

    override fun onInteractWithView(behaviorFragment: BaseBehaviorFragment) {
        channelCommunicationFragmentActivity?.openThisFragment(behaviorFragment)
    }
}