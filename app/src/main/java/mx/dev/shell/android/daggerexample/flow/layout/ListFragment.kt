package mx.dev.shell.android.daggerexample.flow.layout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import mx.dev.shell.android.daggerexample.R
import mx.dev.shell.android.daggerexample.databinding.FragmentListBinding
import mx.dev.shell.android.daggerexample.flow.adapter.ListAdapter
import mx.dev.shell.android.daggerexample.flow.di.DaggerMealsComponent
import mx.dev.shell.android.daggerexample.flow.vm.MealViewModel
import mx.dev.shell.android.daggerexample.flow.vm.MealViewModelFactory
import javax.inject.Inject

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val mealsAdapter = ListAdapter(arrayListOf()) {
        vm.mealDetail.postValue(it)
        val action = ListFragmentDirections.actionListToDetail()
        findNavController().navigate(action)
    }

    @Inject
    lateinit var factory: MealViewModelFactory

    private val vm by navGraphViewModels<MealViewModel>(R.id.navigation_meals) { factory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerMealsComponent.builder()
            .build()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        setupView()
        setupObservers()
        vm.loadMeals()

        return binding.root
    }

    private fun setupView() {
        binding.mealsListRec.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mealsAdapter
        }
    }

    private fun setupObservers() {
        vm.mealList.observe(this as LifecycleOwner) {
            mealsAdapter.setMeals(it)
        }
    }
}