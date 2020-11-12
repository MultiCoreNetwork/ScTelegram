<<<<<<< Updated upstream










__on_telegram_message(bot, message, update) -> (
    print('');
    print('__on_telegram_message(bot, message, update)');
        print('  - bot: ' + bot);
        print('  - message: ' + message);
        print('  - update: ' + update);
);
__on_telegram_inline_query(bot, inline_query, update) -> (
    print('');
    print('__on_telegram_inline_query(bot, inline_query, update)');
        print('  - bot: ' + bot);
        print('  - inline_query: ' + inline_query);
        print('  - update: ' + update);
);
__on_telegram_chosen_inline_query(bot, chosen_inline_query, update) -> (
    print('');
    print('__on_telegram_chosen_inline_query(bot, chosen_inline_query, update)');
        print('  - bot: ' + bot);
        print('  - chosen_inline_query: ' + chosen_inline_query);
        print('  - update: ' + update);
);
__on_telegram_callback_query(bot, callback_query, update) -> (
    print('');
    print('__on_telegram_callback_query(bot, callback_query, update)');
        print('  - bot: ' + bot);
        print('  - callback_query: ' + callback_query);
        print('  - update: ' + update);
);
__on_telegram_edited_message(bot, message, update) -> (
    print('');
    print('__on_telegram_edited_message(bot, message, update)');
        print('  - bot: ' + bot);
        print('  - message: ' + message);
        print('  - update: ' + update);
);
__on_telegram_channel_post(bot, message, update) -> (
    print('');
    print('__on_telegram_channel_post(bot, message, update)');
        print('  - bot: ' + bot);
        print('  - message: ' + message);
        print('  - update: ' + update);
);
__on_telegram_edited_channel_post(bot, message, update) -> (
    print('');
    print('__on_telegram_edited_channel_post(bot, message, update)');
        print('  - bot: ' + bot);
        print('  - message: ' + message);
        print('  - update: ' + update);
);
__on_telegram_shipping_query(bot, shipping_query, update) -> (
    print('');
    print('__on_telegram_shipping_query(bot, shipping_query, update)');
        print('  - bot: ' + bot);
        print('  - shipping_query: ' + shipping_query);
        print('  - update: ' + update);
);
__on_telegram_pre_checkout_query(bot, pre_checkout_query, update) -> (
    print('');
    print('__on_telegram_pre_checkout_query(bot, pre_checkout_query, update)');
        print('  - bot: ' + bot);
        print('  - pre_checkout_query: ' + pre_checkout_query);
        print('  - update: ' + update);
);
__on_telegram_poll(bot, poll, update) -> (
    print('');
    print('__on_telegram_poll(bot, poll, update)');
        print('  - bot: ' + bot);
        print('  - poll: ' + poll);
        print('  - update: ' + update);
);
__on_telegram_poll_answer(bot, poll_answer, update) -> (
    print('');
    print('__on_telegram_poll_answer(bot, poll_answer, update)');
        print('  - bot: ' + bot);
        print('  - poll_answer: ' + poll_answer);
        print('  - update: ' + update);
);
=======
__on_telegram_event(bot, update) -> (
    print('');
    print('__on_telegram_event(bot, update)');
    print('  - bot: ' + bot);
    print('  - update: ' + update)
);

__on_telegram_message(bot, message) -> (
    print('');
    print('__on_telegram_message(bot, message)');
    print('  - bot: ' + bot);
    print('  - message: ' + message)
);

__on_telegram_inline_query(bot, inline_query) -> (
    print('');
    print('__on_telegram_inline_query(bot, inline_query)');
    print('  - bot: ' + bot);
    print('  - inline_query: ' + inline_query)
);

__on_telegram_chosen_inline_result(bot, chosen_inline_result) -> (
    print('');
    print('__on_telegram_chosen_inline_result(bot, chosen_inline_result)');
    print('  - bot: ' + bot);
    print('  - chosen_inline_result: ' + chosen_inline_result)
);

__on_telegram_callback_query(bot, callback_query) -> (
    print('');
    print('__on_telegram_callback_query(bot, callback_query)');
    print('  - bot: ' + bot);
    print('  - callback_query: ' + callback_query)
);

__on_telegram_edited_message(bot, message) -> (
    print('');
    print('__on_telegram_edited_message(bot, message)');
    print('  - bot: ' + bot);
    print('  - message: ' + message)
);

__on_telegram_channel_post(bot, message) -> (
    print('');
    print('__on_telegram_channel_post(bot, message)');
    print('  - bot: ' + bot);
    print('  - message: ' + message)
);

__on_telegram_edited_channel_post(bot, message) -> (
    print('');
    print('__on_telegram_edited_channel_post(bot, message)');
    print('  - bot: ' + bot);
    print('  - message: ' + message)
);

__on_telegram_shipping_query(bot, shipping_query) -> (
    print('');
    print('__on_telegram_shipping_query(bot, shipping_query)');
    print('  - bot: ' + bot);
    print('  - shipping_query: ' + shipping_query)
);

__on_telegram_pre_checkout_query(bot, pre_checkout_query) -> (
    print('');
    print('__on_telegram_pre_checkout_query(bot, pre_checkout_query)');
    print('  - bot: ' + bot);
    print('  - pre_checkout_query: ' + pre_checkout_query)
);

__on_telegram_poll(bot, poll) -> (
    print('');
    print('__on_telegram_poll(bot, poll)');
    print('  - bot: ' + bot);
    print('  - poll: ' + poll)
);

__on_telegram_poll_answer(bot, poll_answer) -> (
    print('');
    print('__on_telegram_poll_answer(bot, poll_answer)');
    print('  - bot: ' + bot);
    print('  - poll_answer: ' + poll_answer)
)
>>>>>>> Stashed changes
