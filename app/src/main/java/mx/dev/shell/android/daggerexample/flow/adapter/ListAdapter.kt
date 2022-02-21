package mx.dev.shell.android.daggerexample.flow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mx.dev.shell.android.daggerexample.core.model.MealBo
import mx.dev.shell.android.daggerexample.databinding.ItemMealBinding

class ListAdapter(
    private val list: ArrayList<MealBo>,
    private val onItemSelected: (MealBo) -> Unit
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemMealBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position], onItemSelected)

    override fun getItemCount() = list.size

    fun setMeals(newMeals: List<MealBo>) {
        list.clear()
        list.addAll(newMeals)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ItemMealBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val container = binding.itemMealContainer
        private val txtName = binding.itemMealName
        private val txtDescription = binding.itemMealDescription
        private val imgMeal = binding.itemMealImg

        fun bind(meal: MealBo, onItemSelected: (MealBo) -> Unit) {
            txtName.text = meal.name
            txtDescription.text = meal.description
            Glide.with(binding.root.context)
                .load(meal.imgSrc)
                .centerCrop()
                .into(imgMeal)
            imgMeal.contentDescription = meal.name
            container.setOnClickListener {
                onItemSelected(meal)
            }

        }
    }
}