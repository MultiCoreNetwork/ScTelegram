__on_telegram_chat_join(bot, chat, user) -> (
    print('');
    print('__on_telegram_join_chat(bot, chat, user)');
    print('  - bot: ' + bot);
    print('  - chat: ' + chat);
    print('  - user: ' + user)
);

__on_telegram_chat_message(bot, chat, user, message) -> (
    print('');
    print('__on_telegram_chat_message(bot, chat, user, message)');
    print('  - bot: ' + bot);
    print('  - chat: ' + chat);
    print('  - user: ' + user);
    print('  - message: ' + message)
);

__on_telegram_chat_message_pinned(bot, chat, user, message) -> (
    print('');
    print('__on_telegram_chat_message_pinned(bot, chat, user, message)');
    print('  - bot: ' + bot);
    print('  - chat: ' + chat);
    print('  - user: ' + user);
    print('  - message: ' + message)
);

__on_telegram_chat_file_message(bot, chat, user, message, file, type) -> (
    print('');
    print('__on_telegram_chat_file_message(bot, chat, user, message, file, type)');
    print('  - bot: ' + bot);
    print('  - chat: ' + chat);
    print('  - user: ' + user);
    print('  - message: ' + message);
    print('  - file: ' + file);
    print('  - type: ' + type)
)
