package com.yipl.labelstep.ui.dialogfragment

import android.app.Dialog
import android.content.DialogInterface
import android.databinding.DataBindingUtil
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.almondcafe.R
import com.example.almondcafe.database.model.Item
import com.example.almondcafe.databinding.FragmentAddItemDialogBinding
import com.example.almondcafe.ui.activity.viewmodel.AddItemDialogFragmentViewModel
import com.example.almondcafe.viewmodel.MainActivityVM
import dagger.android.support.DaggerAppCompatDialogFragment
import javax.inject.Inject




class AddItemDialogFragment: DaggerAppCompatDialogFragment(), AdapterView.OnItemSelectedListener {
    @Inject
    lateinit var mainActivityVM: MainActivityVM
    var item:Item ? =null
    lateinit var binding: FragmentAddItemDialogBinding

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(context, "positiin:$position", Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun getInstance(item: Item?): AddItemDialogFragment {
            val correctiveActionsDialogFragment = AddItemDialogFragment()
            correctiveActionsDialogFragment.item=item
            return correctiveActionsDialogFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBuilder = AlertDialog.Builder(context!!)
        binding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.fragment_add_item_dialog, null, false)
        dialogBuilder
            .setView(binding.root)
            .setTitle("Add Item")
        binding.viewModel= AddItemDialogFragmentViewModel()
        binding.buttonCancelAddingItem.setOnClickListener {
            dialog.dismiss()
        }

        if(item!=null){
            binding.viewModel!!.setData(item!!)
            dialogBuilder.setTitle("Update Item")
        }
        val spinner: Spinner = binding.spinnerCategory
        spinner.onItemSelectedListener = this
        spinner.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            context!!,
            R.array.items_categoy,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        binding.imageViewDelete.setOnClickListener {

            val dialogBuilder = android.app.AlertDialog.Builder(context)
            dialogBuilder.setPositiveButton("Yes") { dialog: DialogInterface?, which: Int ->
                mainActivityVM.deleteItem(item!!)
                getDialog().dismiss()
            }
            dialogBuilder.setNegativeButton("No") { dialog: DialogInterface?, which: Int -> }
            dialogBuilder.setTitle("Are you sure that you want to delete this item?")
            dialogBuilder.show()
        }
        binding.buttonAdd.setOnClickListener {
            val itemName = binding.editTextItemName.text.toString()
            val itemPrice = binding.editTextItemPrice.text.toString()
            val itemQuantity = binding.editTextItemQuantity.text.toString()
            val itemCategory = binding.spinnerCategory.selectedItemPosition

            if (itemName.isNotEmpty() && itemPrice.isNotEmpty() && itemQuantity.isNotEmpty()) {
                if(item!=null){
                    val item = Item(this.item!!.id, itemName, itemPrice.toInt(), itemQuantity.toInt())
                    mainActivityVM.updateItem(item)
                }else{
                    val item = Item(0, itemName, itemPrice.toInt(), itemQuantity.toInt())
                    mainActivityVM.insertItem(item)
                }
                dialog.dismiss()
            } else {
                Toast.makeText(context, "Fill all the boxes", Toast.LENGTH_SHORT).show()
            }
        }
        val alertDialog = dialogBuilder.create()
        return alertDialog
    }
}
