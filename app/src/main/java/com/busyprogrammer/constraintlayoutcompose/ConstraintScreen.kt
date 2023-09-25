package com.busyprogrammer.constraintlayoutcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.busyprogrammer.constraintlayoutcompose.ui.theme.ConstraintLayoutComposeTheme
import com.busyprogrammer.constraintlayoutcompose.ui.theme.LightGray


@Composable
fun ConstraintLayoutScreen() {

    ConstraintLayout(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
    ) {

        val (backIcon, moreIcon, greetingMessage, profileImage, followers, followersText, following,
            followingText, bottomSheetCard, serviceText, consultationIcon, consultationText, androidIcon, androidText, iosIcon, iosText) = createRefs()

        val (flutterIcon, flutterText, reactNativeIcon, reactNativeText, webIcon, webtext, followMeBtn, hireMeBtn) = createRefs()

        //Guidelines
        val horizontalCenterGuideLine = createGuidelineFromTop(0.40f)
        val topGuideLine = createGuidelineFromTop(16.dp)
        val startGuideLine = createGuidelineFromStart(16.dp)



        createHorizontalChain(backIcon, moreIcon, chainStyle = ChainStyle.SpreadInside)

        Image(painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "backIcon",
            modifier = Modifier
                .constrainAs(backIcon) {
                    top.linkTo(topGuideLine)
                    start.linkTo(startGuideLine)
                }
                .padding(start = 16.dp)
                .size(24.dp)
        )

        Image(painter = painterResource(id = R.drawable.ic_more),
            contentDescription = "moreIcon",
            modifier = Modifier
                .constrainAs(moreIcon) {
                    top.linkTo(topGuideLine)
                }
                .padding(end = 16.dp)
                .size(24.dp)
        )


        val greetingBarrier =
            createEndBarrier(greetingMessage, followers, followersText, following, followingText)

        val userName = "Alex"

        val nameWithUser = "Welcome! \n $userName"

        Text(text = nameWithUser,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.constrainAs(greetingMessage) {
                top.linkTo(backIcon.bottom, margin = 32.dp)
                start.linkTo(startGuideLine)
            })
//followers

        Text(text = "21.k",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.constrainAs(followers) {
                top.linkTo(greetingMessage.bottom, 50.dp)
                start.linkTo(greetingMessage.start)
                end.linkTo(followersText.end)
            })


        Text(text = "Followers",
            color = Color.Gray,
            modifier = Modifier.constrainAs(followersText) {
                top.linkTo(followers.bottom, 4.dp)
                start.linkTo(greetingMessage.start)
            })


//following
        Text(text = "100",
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            color = Color.Black,
            modifier = Modifier.constrainAs(following) {
                top.linkTo(greetingMessage.bottom, 50.dp)
                end.linkTo(profileImage.start, 10.dp)
            })

        Text(text = "Following",
            color = Color.Gray,
            modifier = Modifier.constrainAs(followingText) {
                top.linkTo(following.bottom, 4.dp)
                end.linkTo(profileImage.start)
            })



        Image(
            painter = painterResource(id = R.drawable.profile), contentDescription = "profileImage",
            contentScale = ContentScale.Inside,
            modifier = Modifier.constrainAs(profileImage) {
                top.linkTo(moreIcon.bottom)
                start.linkTo(greetingBarrier)
                end.linkTo(moreIcon.end)
                bottom.linkTo(horizontalCenterGuideLine)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        )


        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            modifier = Modifier.constrainAs(bottomSheetCard) {
                top.linkTo(horizontalCenterGuideLine)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        ) {}

        Text(text = "My Services",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(serviceText) {
                top.linkTo(bottomSheetCard.top, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })


        createHorizontalChain(
            consultationIcon,
            androidIcon,
            iosIcon,
            chainStyle = ChainStyle.Spread
        )

        Image(painter = painterResource(id = R.drawable.talk),
            contentDescription = "consultation",
            modifier = Modifier
                .constrainAs(consultationIcon) {
                    top.linkTo(serviceText.bottom, margin = 20.dp)
                }
                .size(50.dp)
        )

        Image(painter = painterResource(id = R.drawable.android),
            contentDescription = "android",
            modifier = Modifier
                .constrainAs(androidIcon) {
                    top.linkTo(consultationIcon.top)
                    bottom.linkTo(consultationIcon.bottom)
                }
                .size(50.dp)
        )

        Image(painter = painterResource(id = R.drawable.apple),
            contentDescription = "apple",
            modifier = Modifier
                .constrainAs(iosIcon) {
                    top.linkTo(consultationIcon.top)
                    bottom.linkTo(consultationIcon.bottom)
                }
                .size(50.dp)
        )


        Text(text = "Consultation",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(consultationText) {
                top.linkTo(consultationIcon.bottom, 12.dp)
                start.linkTo(consultationIcon.start)
                end.linkTo(consultationIcon.end)
            })


        Text(text = "Android",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(androidText) {
                top.linkTo(consultationText.top)
                start.linkTo(androidIcon.start)
                end.linkTo(androidIcon.end)
            })

        Text(text = "iOS",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(iosText) {
                top.linkTo(consultationText.top)
                start.linkTo(iosIcon.start)
                end.linkTo(iosIcon.end)
            })


        createHorizontalChain(flutterIcon, reactNativeIcon, webIcon, chainStyle = ChainStyle.Spread)


        Image(painter = painterResource(id = R.drawable.flutter),
            contentDescription = "fluuterIcon",
            modifier = Modifier
                .constrainAs(flutterIcon) {
                    top.linkTo(consultationText.bottom, margin = 16.dp)
                }
                .size(50.dp)
        )

        Image(painter = painterResource(id = R.drawable.react_native),
            contentDescription = "rnIcon",
            modifier = Modifier
                .constrainAs(reactNativeIcon) {
                    top.linkTo(androidText.bottom, margin = 16.dp)
                }
                .size(50.dp)
        )

        Image(painter = painterResource(id = R.drawable.web),
            contentDescription = "webIcon",
            modifier = Modifier
                .constrainAs(webIcon) {
                    top.linkTo(iosText.bottom, margin = 16.dp)
                }
                .size(50.dp)
        )


        Text(text = "Flutter",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(flutterText) {
                top.linkTo(flutterIcon.bottom, 12.dp)
                start.linkTo(flutterIcon.start)
                end.linkTo(flutterIcon.end)
            })


        Text(text = "React Native",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(reactNativeText) {
                top.linkTo(reactNativeIcon.bottom, 12.dp)
                start.linkTo(reactNativeIcon.start)
                end.linkTo(reactNativeIcon.end)
            })

        Text(text = "Web",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(webtext) {
                top.linkTo(webIcon.bottom, 12.dp)
                start.linkTo(webIcon.start)
                end.linkTo(webIcon.end)
            })


        val horizontalGuideLineBottom = createGuidelineFromBottom(.13f)


        createHorizontalChain(followMeBtn, hireMeBtn, chainStyle = ChainStyle.Spread)

        Button(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = LightGray),
            modifier = Modifier.constrainAs(followMeBtn) {
                top.linkTo(horizontalGuideLineBottom, 12.dp)
            }
        ) {

            Image(painter = painterResource(id = R.drawable.ic_add), contentDescription = "add")
            Spacer(modifier = Modifier.padding(end = 2.dp))
            Text(text = "Follow Me")

        }

        Button(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = LightGray),
            modifier = Modifier.constrainAs(hireMeBtn) {
                top.linkTo(horizontalGuideLineBottom, 12.dp)
            }
        ) {

            Text(text = "Hire Me")

        }

    }

}

@Composable
fun ConstraintSetExample() {

    val constraintSet = ConstraintSet {
        val welcomeText = createRefFor("welcome")
        val follower = createRefFor("follower")
        val followerText = createRefFor("followerText")
        val image = createRefFor("image")

        constrain(welcomeText) {
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
            start.linkTo(parent.start, 5.dp)
            top.linkTo(parent.top, 5.dp)
        }

        constrain(follower) {
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
            start.linkTo(parent.start, 5.dp)
            top.linkTo(welcomeText.bottom, 5.dp)
        }

        constrain(followerText) {
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
            start.linkTo(follower.start, 5.dp)
            top.linkTo(follower.bottom, 5.dp)
        }

        constrain(image) {
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
            start.linkTo(followerText.end, 5.dp)
            top.linkTo(follower.top, 5.dp)
        }


    }

    ConstraintLayout(constraintSet = constraintSet, modifier = Modifier.fillMaxSize()) {
        Text(text = "Welocme", modifier = Modifier.layoutId("welcome"))

        Text(text = "21k", modifier = Modifier.layoutId("follower"))

        Text(text = "Followers", modifier = Modifier.layoutId("followerText"))

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "profile",
            modifier = Modifier.layoutId("image")
        )

    }

}


@Preview(showBackground = true)
@Composable
fun Preview() {
    ConstraintLayoutComposeTheme {
        ConstraintLayoutScreen()
    }
}
