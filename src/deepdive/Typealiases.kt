package deepdive

/**
 * Type aliases simply provide alternative names for existing types.
 * This serves better readability and clarity purposes.
 *
 * Let's suppose we need to store a mapping of facility name in system A to the name in system B.
 * This name may reflect the intention / usage better.
 *
 * Type aliases become especially handy when the type has multiple nested collections, like
 * Map<A, Map<B, List<C>>. A more clear whole-structure type name helps here.
 */
typealias FacilityNameMappings = Map<String, String>

/**
 * Let's suppose we have a function "startMobileApp" (the commented one).
 * The "handler" parameter is quite ambiguous. What does it handle?
 *
 * If we create a type alias [HomeButtonClickHandler] for it, it becomes much clearer,
 * that this handler is triggered when the app user clicks "Home" button.
 * (see the uncommented [startMobileApp] function).
 */
typealias HomeButtonClickHandler = (String, String) -> Unit

//fun startMobileApp(
//    parameters: Set<String>,
//    handler: (String, String) -> Unit
//) {}

/**
 * Of course, it's better to rename the parameter "handler" to "homeButtonClickHandler".
 * Parameter names are intentionally left the same to highlight that
 * *HomeButtonClickHandler* reads much better in a function signature than *(String, String) -> Unit*
 */
fun startMobileApp(
    parameters: Set<String>,
    handler: HomeButtonClickHandler
) {}