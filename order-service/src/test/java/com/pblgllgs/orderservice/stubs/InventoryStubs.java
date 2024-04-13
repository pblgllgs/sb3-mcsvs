package com.pblgllgs.orderservice.stubs;
/*
 *
 * @author pblgl
 * Created on 13-04-2024
 *
 */

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class InventoryStubs {

    public static void stubInventoryCall(String skuCode, int qty) {
        stubFor(get(urlEqualTo("/api/inventory?skuCode=" + skuCode + "&quantity=" + qty))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("true")
                ));
    }
}
