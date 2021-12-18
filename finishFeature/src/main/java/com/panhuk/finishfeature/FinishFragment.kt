package com.panhuk.finishfeature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.panhuk.finishfeature.databinding.FinishFragmentBinding

class FinishFragment : Fragment() {
  private var _binding: FinishFragmentBinding? = null
  private val binding get() = _binding!!

  override fun onAttach(context: Context) {
    //add component
    super.onAttach(context)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FinishFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.finishFragment.setContent { CreateFinishFragment() }
  }

  override fun onDestroyView() {
    _binding = null
    super.onDestroyView()
  }

  @Composable
  @Preview(showBackground = true)
  fun CreateFinishFragment() {
    Column() {
      CreateButton(R.string.retry)
      CreateButton(R.string.go_main_menu)
    }
  }

  @Composable
  fun CreateButton(textId: Int) {
    Button(onClick = { /*TODO*/ }) {
      Text(stringResource(textId))
    }
  }
}