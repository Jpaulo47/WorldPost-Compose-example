package com.joaorodrigues.theworldpost.presentation.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.joaorodrigues.theworldpost.R
import com.joaorodrigues.theworldpost.presentation.Dimens
import com.joaorodrigues.theworldpost.presentation.onboarding.Page
import com.joaorodrigues.theworldpost.presentation.onboarding.pages
import com.joaorodrigues.theworldpost.ui.theme.NewsAppTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {

    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f), contentDescription = null,
            painter = painterResource(id = page.image),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )

        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium)
        )
    }

}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun OnBoardingPagePreview() {
    NewsAppTheme {
        OnBoardingPage(
            page = pages[0]
        )
    }
}