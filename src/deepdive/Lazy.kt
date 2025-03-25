package deepdive

class AppConfig {
    private val remoteConfigProvider = RemoteConfigProvider()

    val localConfig = mapOf(
        "timeout" to 300
    )

    /**
     * *lazy* allows lazy-loading and caching the value for a property.
     *
     * The first call to get() executes the lambda passed to lazy() and caches the result.
     * Subsequent calls to get() simply return the cached result.
     *
     * WARNING:
     * Once the value for a lazy property has been loaded, it works like a cache with NO EXPIRATION POLICY. The value lives forever.
     *
     * *lazy* is particularly useful if loading the property is resource-intensive and may not be always eagerly needed.
     *
     * By default, Kotlin’s *lazy* initialization is thread-safe, making it suitable for concurrent scenarios.\
     * This behaviour may be configured by [LazyThreadSafetyMode]
     */
    val remoteConfig: Map<String, String> by lazy {
        println("Lazy loading of the remote configuration invoked")
        remoteConfigProvider.getConfig()
    }
}

/**
 * Let's suppose this class makes an external call to fetch the config
 */
class RemoteConfigProvider {
    fun getConfig(): Map<String, String> = mapOf(
        "timeout" to "60"
    )
}

fun main() {
    val appConfig = AppConfig()
    println("AppConfig instance created")

    println("Accessing configuration data from the local config")
    println("Timeout: ${appConfig.localConfig["timeout"]} seconds") // no remote config loading happens

    println("Accessing configuration data from the remote config")
    println("Timeout: ${appConfig.remoteConfig["timeout"]} seconds") // remote config is loaded

    println("Accessing configuration data from the remote config once again")
    println("Timeout: ${appConfig.remoteConfig["timeout"]} seconds") // cached value is returned, no loading happens
}


