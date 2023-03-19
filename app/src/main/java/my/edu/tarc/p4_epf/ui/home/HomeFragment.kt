package my.edu.tarc.p4_epf.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import my.edu.tarc.p4_epf.R
import my.edu.tarc.p4_epf.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        //Activity:
        //binding = FragmentHomeBinding.inflate(layoutInflater)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        //Activity:
        //setContentView(binding.root)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // [Button Dividend] to navigate Dividend page
        binding.buttonDividend.setOnClickListener{
            findNavController().navigate(R.id.action_nav_home_to_nav_dividend)
        }

        // [Button Investment] to navigate Investment page
        binding.buttonInvestment.setOnClickListener{
            findNavController().navigate(R.id.action_nav_home_to_nav_investment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}