package cz.kuzna.dagger2_multibinding.detail.ui;

import android.content.Intent;

import com.squareup.okhttp.mockwebserver.Dispatcher;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import cz.kuzna.dagger2_multibinding.BuildConfig;

import static org.junit.Assert.*;

/**
 * @author Radek Kuznik
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class DonutDetailActivityTest {

    private DonutDetailActivity activity;

    @Before
    public void setUp() throws Exception {
        final Intent intent = new Intent();
        intent.putExtra(DonutDetailActivity.EXTRA_DONUT_ID, 2);

        activity = Robolectric.buildActivity(DonutDetailActivity.class).withIntent(intent).create().get();
    }

    @Test
    public void onClickOrderNow() throws Exception {

        final Dispatcher dispatcher = new Dispatcher() {
            @Override
            public MockResponse dispatch(final RecordedRequest request) {
//                if (request.getPath().equals(cz.eago.android.schoolmate.app.Config.SERVER_URI.FAMILY_ASSIGN_PARENT)) {
//                    try {
//                        final FamilyAssignParentRequest parentRequest = new FamilyAssignParentRequest(request.getBody().readUtf8());
//                        assertEquals(EMAIL, parentRequest.getFamilyCreatorEmail());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//
//                    final StatusResponse statusResponse = new StatusResponse();
//                    statusResponse.setErrorCode(ErrorCode.OK);
//                    statusResponse.setStatus(StatusResponse.STATUS_OK);
//
//                    final MockResponse mockResponse = new MockResponse();
//                    try {
//                        mockResponse.setBody(statusResponse.toJson().toString());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    mockResponse.setResponseCode(200);
//                    called = true;
//
//                    return mockResponse;
//                }

                return new MockResponse().setResponseCode(404);
            }
        };

        final MockWebServer server = new MockWebServer();
        server.setDispatcher(dispatcher);
        server.start(48080);
    }
}