import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.almondcafe.R
import com.example.almondcafe.base.BaseFragment
import com.example.almondcafe.databinding.FragmentPastBinding
import com.example.almondcafe.databinding.FragmentSummaryBinding
import com.example.almondcafe.fragment.Past
import com.example.almondcafe.viewmodel.MainActivityVM
import javax.inject.Inject


class Summary: Fragment() {


    @Inject
    lateinit var mainActivityVM: MainActivityVM



//    override fun getLayout(): Int {
//        return R.layout.fragment_summary
//    }
//
//    override fun isDataBindingEnabled(): Boolean {
//        super.isDataBindingEnabled()
//        return true
//    }

    companion object {
        fun newInstance(): Summary {
            val fragment = Summary()
            return fragment
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}