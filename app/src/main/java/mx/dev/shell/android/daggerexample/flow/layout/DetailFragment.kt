package mx.dev.shell.android.daggerexample.flow.layout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.bumptech.glide.Glide
import mx.dev.shell.android.daggerexample.R
import mx.dev.shell.android.daggerexample.databinding.FragmentDetailBinding
import mx.dev.shell.android.daggerexample.flow.di.DaggerMealsComponent
import mx.dev.shell.android.daggerexample.flow.vm.MealViewModel
import mx.dev.shell.android.daggerexample.flow.vm.MealViewModelFactory
import javax.inject.Inject

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

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
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        setupObservers()

        return binding.root
    }

    private fun setupObservers() {
        vm.mealDetail.value?.apply {
            binding.mealName.text = name
            binding.mealDescription.text = description
            Glide.with(this@DetailFragment)
                .load(imgSrc)
                .centerCrop()
                .into(binding.mealImg)
            binding.mealImg.contentDescription = name
        }
    }
}