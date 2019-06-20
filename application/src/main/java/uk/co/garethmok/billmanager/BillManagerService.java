package uk.co.garethmok.billmanager;

import uk.co.garethmok.documents.DocumentsApiClient;

public class BillManagerService {

    private DocumentsApiClient documentsApiClient;

    public BillManagerService(final DocumentsApiClient documentsApiClient) {
        this.documentsApiClient = documentsApiClient;
    }

    String whatever() {
        return this.documentsApiClient.getDocs();
    }
}
