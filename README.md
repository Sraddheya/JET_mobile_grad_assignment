# JET_mobile_grad_assignment

Coding assignment for the JET Mobile Graduate Scheme 2025

## Screenshot Example

![Mobile app screenshot](https://github.com/sraddheya/JET_mobile_grad_assignment/blob/main/app_screenshot.png)<img width="10">

## How to Build, Compile, and Run The Program

1. Install Android Studio. Instructions can be found using the page [Install Android Studio](https://developer.android.com/studio/install).
2. Clone the repo and open it in Android Studio.
3. Go to the top bar of Android studio and create an emulator or pair a device to run the app on. The app should be able to run on Android 10 and above. Instructions can be found on the page [Build and run your app](https://developer.android.com/studio/run)
4. Go to the top bar of Android Studio and click the green 'Run' button to run the app. Input the postcode as requested.

## Assumptions

- The postcodes follow the [UK postal code format](https://assets.publishing.service.gov.uk/media/5a81ebbded915d74e6234d42/Appendix_C_ILR_2017_to_2018_v1_Published_28April17.pdf).
- Restaurant name outputted instead of unique restaurant name because this is more readable for users.
- Restaurant address is outputted, not including the coordinates, because they are not as meaningful to users as a standard address.
- All the data in restaurants will have a value for each field. For example, if the restaurant is new, it will still have a star rating of 0.

## Improvements

- Improve the design of how the restaurant data is displayed to the user.
- Add a loading spinner when the app is fetching data from the API.
- Include testing, particularly for the exceptions/edge cases.
- Hide keyboard when the user is not typing.
- Allow the user to search by hitting enter on the keyboard.
- Make the toast when there is an error more obvious.
