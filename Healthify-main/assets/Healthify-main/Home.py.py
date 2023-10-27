import streamlit as st
import streamlit as st


def home():
    st.set_page_config(
        page_title="Health Rakshak - Home",
        page_icon="👨‍⚕️",
    )
    st.sidebar.info(
        "**About**: This project is made using publicly available data and comes with no gaurantee. We do not store any of the patient's personal information."
    )

    # st.markdown(f"<h1 style='text-align: center; color: blue; font-size: 50px;'>Health Rakshak</h1>", unsafe_allow_html=True)
    col1, col2, col3 = st.columns([1, 6, 1])

    with col1:
        st.write("")

    with col2:
        st.image("assets./logorounded.png")

    with col3:
        st.write("")
    # st.image("logo/logo.png")

    st.markdown(
        '<p style="font-size:22px; text-align: center; color: black;font-size: 25px;">Enhancing Lives, Improving Healthcare Connecting the dots between health and technology</p>',
        unsafe_allow_html=True,
    )
    st.markdown("---")

    st.markdown(
        f"<h2 style='text-align: center; color: gold; background-color: black;'>About the website</h2>",
        unsafe_allow_html=True,
    )
    st.write("")

    st.markdown(
        f"<p style='text-align: center; color: black; font-size: 20px'> ✳️ Using cutting-edge deep learning and machine learning technologies, we can assign you a virtual health consultant.</p>",
        unsafe_allow_html=True,
    )

    st.markdown(
        f"<p style='text-align: center; color: black; font-size: 20px'> ✳️ With the use of cutting-edge analytics, we empower the care experiences of the general public and healthcare organizations by offering digital health and healthcare solutions.</p>",
        unsafe_allow_html=True,
    )

    st.markdown("---")

    st.markdown(
        f"<h2 style='text-align: center; color: gold; background-color: black;'>Our Services</h2>",
        unsafe_allow_html=True,
    )
    st.write("")

    st.markdown(
        f"⚕️ **Disease Diagnosis** - Enter the symptoms you are suffering from and you will get to know the disease you are suffering from, precautions to take, medications and specialists near you to cure the disease"
    )
    st.markdown(
        f"⚕️ **Early Diabetes Detection** - Enter the patients attributes from the test report and check whether he/she have chances of diabetes or not"
    )

    st.markdown(
        f"⚕️ **Liver Disease Detection** - Enter the patients attributes from the test report and check whether he/she have chances of any type of liver disease or not"
    )

    st.markdown(
        f"⚕️ **Malaria Detection** - Upload the microscopic cell-image of the patient and check whether the patient have chances of malaria"
    )
    st.markdown(
        f"⚕️ **Pneumonia Detection** - Upload the chest X-ray image of the patient and check whether the patient have chances of Pneumonia"
    )

    st.markdown("---")

    st.warning(
        "**Disclaimer**: A qualified medical practitioner should always be consulted for a diagnosis, treatment, or advice. It is only intended for general informative purposes. For proper guidance, always seek the opinion of a healthcare expert. Do not postpone getting medical attention because of material on this website. We do not recommend any particular tests, goods, or service providers from this website. Any items, services, or information you get through this website are not under our control."
    )


if __name__ == "__main__":
    home()
