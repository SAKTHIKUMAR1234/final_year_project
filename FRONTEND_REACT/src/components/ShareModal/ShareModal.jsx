import { Modal, useMantineTheme } from "@mantine/core";
import PostShare from "../PostShare/PostShare";
import React from "react";
import { useMediaQuery } from "@mantine/hooks";

function ShareModal({ modalOpened, setModalOpened }) {
    const theme = useMantineTheme();
    const isMobile = useMediaQuery("(max-width:50em)");
    return (
        <Modal
            overlayColor={
                theme.colorScheme === "dark"
                    ? theme.colors.dark[9]
                    : theme.colors.gray[6]
            }
            fullscreen={isMobile}
            size="auto"
            withCloseButton={false}
            opened={modalOpened}
            onClose={() => setModalOpened(false)}
            centered
            padding="0%"
        >
            <PostShare />
        </Modal>
    );
}

export default ShareModal;