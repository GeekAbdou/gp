package com.example.booksaplicationkotlin.ui.screens.graduation_projects.search

import androidx.recyclerview.widget.DiffUtil
import com.example.booksaplicationkotlin.R
import com.example.booksaplicationkotlin.model.GradProject
import com.example.readx.ui.base.BaseAdapter
import com.example.readx.ui.base.BaseInteractionListener

//
//class BookViewHolder(bookItemBinding: GradProjectItemBinding): RecyclerView.ViewHolder(bookItemBinding.root)
//class BooksDiffUtil:DiffUtil.ItemCallback<Record>(){
//    override fun areItemsTheSame(oldItem: Record, newItem: Record): Boolean {
//        return oldItem === newItem
//    }
//
//    override fun areContentsTheSame(oldItem: Record, newItem: Record): Boolean {
//        return oldItem == newItem
//    }
//
//}
//
//class ProjectsAdapter(val onClickListener: OnClickListener):androidx.recyclerview.widget.ListAdapter<Record, BookViewHolder>(
//    BooksDiffUtil()
//) {
//   lateinit var binding:GradProjectItemBinding
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
//        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context)
//            , R.layout.book_item,parent, false)
//        return GradProjectItemBinding(binding)
//
//    }
//
//    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
//        val current_obj = getItem(position)
//        binding.book = current_obj
//        binding.bookItemCardView.setOnClickListener {
//            onClickListener.onClickBookItem(current_obj)
//        }
//
//        //binding.bookItemImg.let { Glide.with(holder.itemView).load(current_obj.image).centerCrop().into(it)}
//       /* binding.bookItemImg.let { Glide.with(holder.itemView).load(R.drawable.book).centerCrop().into(it) }
//        binding.bookItemName.text = current_obj.name
//        binding.bookItemAuthorName.text = current_obj.authorName.toString()
//        binding.bookItemDescriptionValue.text = current_obj.description*/
//
//    }

//}



class GraduationProjectsAdapter(listener: GradProjectInteractionListener?) : BaseAdapter<GradProject>(
    listener
){
    override val layoutId = R.layout.grad_project_item

}


interface GradProjectInteractionListener: BaseInteractionListener{
    fun onClickGradProject(gradProject: GradProject)
}

class GradProjectItemUiStateDiffUtil: DiffUtil.ItemCallback<GradProject>() {
    override fun areItemsTheSame(
        oldItem: GradProject,
        newItem: GradProject
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: GradProject,
        newItem: GradProject
    ): Boolean = oldItem == newItem

}