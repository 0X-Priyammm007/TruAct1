package com.truact.ml.preprocessing;

import com.truact.model.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class FeatureExtractor {

    /**
     * Extracts features from a list of transactions for model training.
     *
     * @param transactions List of transactions to extract features from.
     * @return List of feature vectors representing the transactions.
     */
    public List<double[]> extractFeatures(List<Transaction> transactions) {
        return transactions.stream()
                .map(this::extractFeaturesFromTransaction)
                .collect(Collectors.toList());
    }

    /**
     * Extracts features from a single transaction.
     *
     * @param transaction The transaction to extract features from.
     * @return An array of features representing the transaction.
     */
    private double[] extractFeaturesFromTransaction(Transaction transaction) {
        // Example feature extraction logic
        double[] features = new double[3]; // Adjust size based on actual features

        features[0] = transaction.getAmount().doubleValue(); // Feature: Transaction Amount
        features[1] = transaction.getTimestamp().toEpochSecond(java.time.ZoneOffset.UTC); // Feature: Transaction Time
        features[2] = transaction.getUserId(); // Feature: User ID

        return features;
    }
}