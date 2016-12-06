package cz.kuzna.dagger2_multibinding.detail.ui;

import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.mockwebserver.Dispatcher;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import cz.kuzna.dagger2_multibinding.BuildConfig;
import cz.kuzna.dagger2_multibinding.R;
import cz.kuzna.dagger2_multibinding.order.dataaccess.OrderResultDto;
import cz.kuzna.test.RxSchedulersOverrideRule;

import static org.junit.Assert.*;

/**
 * @author Radek Kuznik
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class DonutDetailActivityIT {

    @Rule
    public final RxSchedulersOverrideRule overrideRule = new RxSchedulersOverrideRule();

    private DonutDetailActivity activity;

    @Before
    public void setUp() throws Exception {
        final Intent intent = new Intent();
        intent.putExtra(DonutDetailActivity.EXTRA_DONUT_ID, 2);

        activity = Robolectric.buildActivity(DonutDetailActivity.class).withIntent(intent).create().get();
    }

    @Test
    public void onClickOrderNow_return_true() throws Exception {

        final Dispatcher dispatcher = new Dispatcher() {
            @Override
            public MockResponse dispatch(final RecordedRequest request) {
                if (request.getPath().equals("/donut/order")) {
                    final OrderResultDto resultDto = new OrderResultDto();
                    resultDto.setStatus(true);

                    final MockResponse mockResponse = new MockResponse();
                    try {
                        mockResponse.setBody(new Gson().toJson(resultDto));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    mockResponse.setResponseCode(200);
                    return mockResponse;
                }

                return new MockResponse().setResponseCode(404);
            }
        };

        final MockWebServer server = new MockWebServer();
        server.setDispatcher(dispatcher);
        server.start(48123);

        final Button btnOrderNow = (Button) activity.findViewById(R.id.btn_order_now);
        btnOrderNow.performClick();

        server.shutdown();

        final Toast latestToast = ShadowToast.getLatestToast();

        assertNotNull(latestToast);
        assertEquals(latestToast.getDuration(), Toast.LENGTH_LONG);
        assertEquals(ShadowToast.getTextOfLatestToast(), "Order was submitted");
    }

    @Test
    public void onClickOrderNow_return_false_200() throws Exception {
        final Dispatcher dispatcher = new Dispatcher() {
            @Override
            public MockResponse dispatch(final RecordedRequest request) {
                if (request.getPath().equals("/donut/order")) {
                    final OrderResultDto resultDto = new OrderResultDto();
                    resultDto.setStatus(false);

                    final MockResponse mockResponse = new MockResponse();
                    try {
                        mockResponse.setBody(new Gson().toJson(resultDto));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    mockResponse.setResponseCode(200);
                    return mockResponse;
                }

                return new MockResponse().setResponseCode(404);
            }
        };

        final MockWebServer server = new MockWebServer();
        server.setDispatcher(dispatcher);
        server.start(48123);

        final Button btnOrderNow = (Button) activity.findViewById(R.id.btn_order_now);
        btnOrderNow.performClick();

        server.shutdown();

        final Toast latestToast = ShadowToast.getLatestToast();

        assertNotNull(latestToast);
        assertEquals(latestToast.getDuration(), Toast.LENGTH_LONG);
        assertEquals(ShadowToast.getTextOfLatestToast(), "Order failed");
    }

    @Test
    public void onClickOrderNow_return_false_404() throws Exception {
        final Dispatcher dispatcher = new Dispatcher() {
            @Override
            public MockResponse dispatch(final RecordedRequest request) {
                return new MockResponse().setResponseCode(404);
            }
        };

        final MockWebServer server = new MockWebServer();
        server.setDispatcher(dispatcher);
        server.start(48123);

        final Button btnOrderNow = (Button) activity.findViewById(R.id.btn_order_now);
        btnOrderNow.performClick();

        server.shutdown();

        final Toast latestToast = ShadowToast.getLatestToast();

        assertNotNull(latestToast);
        assertEquals(latestToast.getDuration(), Toast.LENGTH_LONG);
        assertEquals(ShadowToast.getTextOfLatestToast(), "Order failed");
    }
}