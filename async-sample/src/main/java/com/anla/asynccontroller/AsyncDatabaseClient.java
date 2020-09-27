package com.anla.asynccontroller;

import java.util.concurrent.CompletionStage;

public interface AsyncDatabaseClient {

	<T> CompletionStage<T> store(CompletionStage<T> stage);
}
