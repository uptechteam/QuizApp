package com.panhuk.firstTimeFeature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.panhuk.firstTimeFeature.databinding.FirstTimeFragmentBinding
import com.panhuk.firstTimeFeature.di.FirstTimeComponent
import javax.inject.Inject

class FirstTimeFragment : Fragment() {
  private var _binding: FirstTimeFragmentBinding? = null
  private val binding get() = _binding!!

  @Inject
  protected lateinit var viewModel: FirstTimeViewModel

  override fun onAttach(context: Context) {
    FirstTimeComponent.create(requireActivity().applicationContext).inject(this)
    super.onAttach(context)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FirstTimeFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}